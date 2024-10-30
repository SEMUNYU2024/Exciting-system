import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@RestController
public class FunFactController {

    @GetMapping("/random-fact")
    public String getRandomFact() {
        String apiUrl = "https://uselessfacts.jsph.pl/random.json?language=en";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);
        JSONObject json = new JSONObject(response);
        return json.getString("text");
    }
}
