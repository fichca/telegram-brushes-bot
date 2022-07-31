package by.liatkouski.api.api.scope.feignclient;

import by.liatkouski.api.api.scope.AnswerApi;
import org.springframework.cloud.openfeign.FeignClient;

// TODO: 10.04.2022  bot_service_url from prop
@FeignClient(name = "bot-service", url = "localhost:8100")
public interface BotApiClient extends AnswerApi {
}
