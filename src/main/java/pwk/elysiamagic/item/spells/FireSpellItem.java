package pwk.elysiamagic.item.spells;

import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class FireSpellItem extends SpellItem {

    public FireSpellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void cast(PlayerEntity player, World world) {
        if(!world.isClient()) {
            Vec3d direction = player.getRotationVector(); // Blickrichtung
            SmallFireballEntity fireball = new SmallFireballEntity(
                    world,
                    player,
                    direction.x,
                    direction.y,
                    direction.z
            );
            fireball.setPosition(player.getX(), player.getEyeY(), player.getZ());
            world.spawnEntity(fireball);
        }
        world.playSound(
                null,
                player.getX(), player.getY(), player.getZ(),
                net.minecraft.sound.SoundEvents.ENTITY_BLAZE_SHOOT,
                net.minecraft.sound.SoundCategory.PLAYERS,
                1.0f,
                1.0f
        );
    }
}
