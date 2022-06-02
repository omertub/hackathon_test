import { UnauthorizedException } from '@nestjs/common';
import { Injectable, Inject } from '@nestjs/common';
import { Repository } from 'typeorm';
import { LoginDto } from './dto/login.dto';
import { SignupDto } from './dto/signup.dto';
import { User } from './users.entity';

@Injectable()
export class UserService {
  constructor(
    @Inject('USERS_REPOSITORY')
    private usersRepository: Repository<User>,
  ) {}

  async findAll(): Promise<User[]> {
    return this.usersRepository.find();
  }

  // just for testing!
  async signup(signupDto: SignupDto): Promise<User> {
    return this.usersRepository.save({
        ...signupDto,
        hashedPassword: '',
        salt: ''
    });
  }

  // just for testing!
  async login(loginDto: LoginDto) {
    const user = await this.usersRepository.findOne({
        where: {
            username: loginDto.username
        }
    });

    if (!user) {
        throw new UnauthorizedException(`Invalid username or password!`);
    }

    console.log("🚀 ~ file: users.service.ts ~ line 42 ~ UserService ~ login ~ user.password", user.password, loginDto.password)
    // just for testing!
    if (user.password !== loginDto.password) {
        throw new UnauthorizedException(`Invalid username or password!`);
    }

    return user;
  }

}
