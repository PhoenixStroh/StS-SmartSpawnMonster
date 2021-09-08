import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import /* FILL DEPENDENCY HERE */.MonsterSpawnHelper;

public class SmartSpawnMonsterAction extends AbstractGameAction {
    private AbstractMonster m;
    
    public SmartSpawnMonsterAction(final AbstractMonster m) {
        
        this.m = m;

        float dist = MonsterSpawnHelper.GetNewPosition(GetLastMonster(), m);
        float loc = MonsterSpawnHelper.GetFlatPos(GetLastMonster().drawX) - dist;
        m.drawX = MonsterSpawnHelper.GetScaledPos(loc);
        actionType = ActionType.SPECIAL;
    }

    private AbstractMonster GetLastMonster() {
        AbstractMonster lastM = null;
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (lastM == null || lastM.drawX > mo.drawX)
                lastM = mo;
        }
        return lastM;
    }

    @Override
    public void update() {
        AbstractDungeon.actionManager.addToBottom( new SpawnMonsterAction(m, false,AbstractDungeon.getCurrRoom().monsters.monsters.size()));
        isDone = true;
    }
}
