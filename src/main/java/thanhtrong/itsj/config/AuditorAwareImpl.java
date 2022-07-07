package thanhtrong.itsj.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Thu, 7/7/2022
 * Time     : 09:06
 * Filename : AuditorAwareImpl
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin");
    }
}
