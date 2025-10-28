package pwk.elysiamagic.item.spells;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningSpellItem extends SpellItem {

    public LightningSpellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void cast(PlayerEntity player, World world) {
        if (!world.isClient()) {
            HitResult hitResult = player.raycast(50.0, 0.0f, false); // Reichweite 50 Blöcke

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                Vec3d hitPos = hitResult.getPos();

                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.refreshPositionAndAngles(hitPos.x, hitPos.y, hitPos.z, player.getYaw(), player.getPitch());
                world.spawnEntity(lightning);

                world.playSound(
                        null,
                        hitPos.x, hitPos.y, hitPos.z,
                        SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER,
                        SoundCategory.WEATHER,
                        2.0f,
                        1.0f
                );
            }
        }
    }
}
