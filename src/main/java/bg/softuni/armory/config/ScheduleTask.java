package bg.softuni.armory.config;

import bg.softuni.armory.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    private final UserService userService;

    public ScheduleTask(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void paymentForAdmin() {
        userService.payFee();
    }
}
