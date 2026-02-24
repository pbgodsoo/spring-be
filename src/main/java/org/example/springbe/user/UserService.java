package org.example.springbe.user;

import lombok.RequiredArgsConstructor;
import org.example.springbe.user.model.User;
import org.example.springbe.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserDto.SignupReq dto) {
        User user = dto.toEntity();
        userRepository.save(user);
    }
}
