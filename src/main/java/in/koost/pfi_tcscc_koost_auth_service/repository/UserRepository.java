package in.koost.pfi_tcscc_koost_auth_service.repository;

import in.koost.pfi_tcscc_koost_auth_service.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    public User findByUsername(String username);
}
