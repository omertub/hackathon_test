import { Controller, Get, Post } from '@nestjs/common';
import { AppService } from './app.service';
import { RESPONSE_STATUS } from './consts/response.status';
import { EventsGateway } from './events.gateway';

@Controller()
export class AppController {
  constructor(
    private readonly appService: AppService,
    private readonly eventsGateway: EventsGateway
    ) {}

  @Get()
  getHello(): string {
    return this.appService.getHello();
  }

  @Post('/pushEvent')
  pushEvent() {
    this.eventsGateway.server.emit('server2client', {
      hello: 'Hello there ;)'
    });

    return { status: RESPONSE_STATUS.OK };
  }
}
