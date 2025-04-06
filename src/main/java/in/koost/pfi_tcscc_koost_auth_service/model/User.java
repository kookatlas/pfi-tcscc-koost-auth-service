package in.koost.pfi_tcscc_koost_auth_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users_login")
public class User {

    @Id
    private Integer id;
    private String username;
    private String password;
}
