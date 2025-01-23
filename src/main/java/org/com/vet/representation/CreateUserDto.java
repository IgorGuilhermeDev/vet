package org.com.vet.representation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.com.vet.anotation.IsValidCPF;
import org.com.vet.model.User;

@Data
public class CreateUserDto {

    @IsValidCPF(message = "O número do CPF não é válido") private String cpf;
    @NotBlank(message = "O nome deve ser informado") private String name;
    @NotBlank(message = "O email deve ser informado") private String email;
    private String phone;
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres") private String password;

    public User toModel(){
        return User.builder()
                .name(this.name)
                .cpf(this.cpf)
                .email(this.email)
                .phone(this.phone)
                .password(this.password).build();
    }
}
