package spring.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.UserResponseDto;
import spring.model.User;
import spring.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> list = new ArrayList<>();
        for (User user : userService.listUsers()) {
            list.add(mapFromUserToUserResponseDto(user));
        }
        return list;
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return mapFromUserToUserResponseDto(userService.findById(id));
    }

    @GetMapping("/inject")
    public String injectUsers() {
        User user1 = new User();
        user1.setName("Sherlock Holmes");
        user1.setEmail("BakerStreet221B");
        user1.setPassword("123");
        userService.add(user1);
        User user2 = new User();
        user2.setName("John Watson");
        user2.setEmail("Vietnam1999");
        user2.setPassword("456");
        userService.add(user2);
        User user3 = new User();
        user3.setName("James Moriarty");
        user3.setEmail("antagonist561");
        user3.setPassword("789");
        userService.add(user3);
        User user4 = new User();
        user4.setName("Mrs. Hudson");
        user4.setEmail("Englishtea11");
        user4.setPassword("012");
        userService.add(user4);
        return "Success! Data already injected in DB";
    }

    private UserResponseDto mapFromUserToUserResponseDto(User user) {
        return new UserResponseDto(user.getName(), user.getEmail());
    }
}
