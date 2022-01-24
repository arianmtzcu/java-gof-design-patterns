package pattern.structural.flyweight;

import java.util.HashMap;

public class EnemyFactory {

    private static HashMap<String, Enemy> enemigos = new HashMap<>();

    /*"", ""*/
    public static Enemy getEnemy(String type) {
        Enemy enemy = null;
        if (enemigos.containsKey(type)) {
            enemy = enemigos.get(type);
        } else {
            switch (type) {
                case "Private":
                    System.out.println("Un nuevo Soladado ha sido creado!");
                    enemy = new Private();
                    break;
                case "Detective":
                    System.out.println("Un nuevo Detective ha sido creado!");
                    enemy = new Detective();
                    break;
                default:
                    System.out.println(String.format("No se ha creado enemigo! [%s]",type));
            }
            enemigos.put(type, enemy);
        }
        return enemy;
    }
}

