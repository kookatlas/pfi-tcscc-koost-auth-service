package in.koost.pfi_tcscc_koost_auth_service.repository;

import in.koost.pfi_tcscc_koost_auth_service.model.UserLogin;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserLogin, Integer> {

    public Mono<UserLogin> findByUsername(String username);
}
