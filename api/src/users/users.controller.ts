import { Get, Post } from "@nestjs/common";
import { Body } from "@nestjs/common";
import { Controller } from "@nestjs/common";
import { LoginDto } from "./dto/login.dto";
import { SignupDto } from "./dto/signup.dto";
import { UserService } from "./users.service";

@Controller()
export class UserController {
    constructor(private userService: UserService) { }

    @Get('users')
    async getUsers() {
        return this.userService.findAll();
    }

    @Post('signup')
    async signup(@Body() signupDto: SignupDto) {
        return this.userService.signup(signupDto);
    }

    @Post('login')
    async login(@Body() loginDto: LoginDto) {
        return this.userService.login(loginDto);
    }

}
