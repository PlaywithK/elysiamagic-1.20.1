package pwk.elysiamagic.item.spells;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SpeedSpellItem extends SpellItem {

    public SpeedSpellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void cast(PlayerEntity player, World world) {
        if (!world.isClient()) {
            int duration = 20 * 30;
            int amplifier = 1;
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, duration, amplifier));

            world.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_PLAYER_LEVELUP,
                    SoundCategory.PLAYERS,
                    1.0f,
                    1.0f
            );
        }
    }
}