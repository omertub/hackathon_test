import { Entity, Column, PrimaryGeneratedColumn, Unique } from 'typeorm';

@Unique(['username'])
@Entity()
export class User {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ length: 30 })
  username: string;

  // just for testing!
  @Column({ length: 64 })
  password: string;

  @Column({ length: 64 })
  hashedPassword: string;

  @Column({ length: 7 })
  salt: string;

}
