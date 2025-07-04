package roomescape.member.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import roomescape.common.exception.AuthenticationException;
import roomescape.common.exception.AuthorizationException;
import roomescape.common.exception.error.GeneralErrorCode;
import roomescape.member.domain.MemberName;

@Component
public class JwtTokenExtractor {

    @Value("${jwt.key}")
    private String SECRET_KEY;

    public String extractTokenFromCookie(Cookie[] cookies) {
        if (cookies == null) {
            throw new AuthorizationException("로그인이 필요합니다.", GeneralErrorCode.MUST_BE_MEMBER);
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                return cookie.getValue();
            }
        }

        throw new AuthorizationException("로그인이 필요합니다.", GeneralErrorCode.MUST_BE_MEMBER);
    }

    public MemberName extractMemberNameFromToken(String token) {
        String name = extractClaimsFromToken(token)
                .get("name").toString();
        return MemberName.from(name);
    }

    public Long extractMemberIdFromToken(String token) {
        Long id = Long.valueOf(extractClaimsFromToken(token).getSubject());
        return id;
    }

    private Claims extractClaimsFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (MalformedJwtException e) {
            throw new AuthenticationException("잘못된 토큰입니다.", GeneralErrorCode.INVALID_AUTH_INFO);
        } catch (ExpiredJwtException e) {
            throw new AuthenticationException("만료된 토큰입니다.", GeneralErrorCode.EXPIRED_TOKEN);
        } catch (JwtException e) {
            throw new AuthenticationException("토큰이 유효하지 않습니다.", GeneralErrorCode.INVALID_AUTH_INFO);
        }
    }
}
