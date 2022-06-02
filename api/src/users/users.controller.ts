import { Get, Post } from "@nestjs/common";
import { Body } from "@nestjs/common";
import { Controller } from "@nestjs/common";
import { RESPONSE_STATUS } from "src/consts/response.status";
import { LoginDto } from "./dto/login.dto";
import { SignupDto } from "./dto/signup.dto";
import { User } from "./users.entity";
import { UserService } from "./users.service";

@Controller()
export class UserController {
    constructor(private userService: UserService) { }

    @Get('users')
    async getUsers() {
        return {
            status: RESPONSE_STATUS.OK,
            users: await this.userService.findAll(),
        };
    }

    @Post('signup')
    async signup(@Body() signupDto: SignupDto) {
        let user: User;

        try {
            user = await this.userService.signup(signupDto);
        }
        catch (err) {
            console.log(err);
            return { status: RESPONSE_STATUS.USERNAME_ALREADY_EXISTS, user: null };    
        }

        return { status: RESPONSE_STATUS.OK, user };
    }

    @Post('login')
    async login(@Body() loginDto: LoginDto) {
        try {
            const user = await this.userService.login(loginDto)
            return { status: RESPONSE_STATUS.OK, user: user }
        }
        catch (err) {
            return { status: RESPONSE_STATUS.INVALID_USERNAME_OR_PASSWORD, user: null }
        }
    }

}
