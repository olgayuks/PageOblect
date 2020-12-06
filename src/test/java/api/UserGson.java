package api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class UserGson {
    String name;
    int id;
    String email;
    boolean is_active;
    int role_id;
    String role;

}
