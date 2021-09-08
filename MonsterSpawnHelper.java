import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.core.Settings;

public class MonsterSpawnHelper {

    private static final float MARGIN = 40F;
    private static final float DEFAULT_MONSTER_SIZE = 140F;

    private static float margin;
    private static float defaultMonsterSize;


    static {
        margin = MARGIN;
        defaultMonsterSize = DEFAULT_MONSTER_SIZE;
    }

    public static float GetScaledPos(float flatPos) {
        return Settings.WIDTH * 0.75F + flatPos * Settings.xScale;
    }

    public static float GetFlatPos(float scaledPos) {
        return (scaledPos - (Settings.WIDTH * 0.75F))/Settings.xScale;
    }

    public static float GetMonsterSize(AbstractMonster m) {
        return m.hb_w;
    }

    public static float GetNewPosition(AbstractMonster startM, AbstractMonster spawnedM) {
        return GetNewPosition(GetMonsterSize(startM), margin, GetMonsterSize(spawnedM));
    }

    public static float GetNewPosition(float startM, float margin, float spawnedM) {
        return ( (startM/2) + margin + (spawnedM/2) );
    }

    public static float GetNewPosition(float startM, float spawnedM) {
        return GetNewPosition(startM, defaultMonsterSize, spawnedM);
    }
}
