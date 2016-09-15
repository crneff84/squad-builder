import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squads", Squad.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-squad", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String squadName = request.queryParams("squad-name");
      Squad newSquad = new Squad(squadName);
      model.put("squads", Squad.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squad/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int squadId = Integer.parseInt(request.params(":id"));
      Squad squad = Squad.find(squadId);
      model.put("squad", squad);
      model.put("template", "templates/squad-display.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-hero", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int squadId = Integer.parseInt(request.queryParams("squadId"));
      Squad squad = Squad.find(squadId);
      String heroName = request.queryParams("hero-name");
      String attackCheck = request.queryParams("hero-attack");
      String defenseCheck = request.queryParams("hero-defense");
      String personalityCheck = request.queryParams("hero-attack");
      if (!attackCheck.equals("") && !defenseCheck.equals("") && !personalityCheck.equals("")) {
        int heroAttack = Integer.parseInt(attackCheck);
        int heroDefense = Integer.parseInt(defenseCheck);
        int heroPersonality = Integer.parseInt(personalityCheck);
        Hero newHero = new Hero(heroName, heroAttack, heroDefense, heroPersonality);
        squad.addHero(newHero);
      }
      model.put("squad", squad);
      model.put("template", "templates/squad-display.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/hero/:squadId/:heroId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int heroId = Integer.parseInt(request.params(":heroId"));
      int squadId = Integer.parseInt(request.params(":squadId"));
      Hero hero = Hero.find(heroId);
      model.put("squadId", squadId);
      model.put("hero", hero);
      model.put("template", "templates/hero-display.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
