package pwk.elysiamagic.item.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TeleportSpellItem extends SpellItem {

    public TeleportSpellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void cast(PlayerEntity player, World world) {
        if (!world.isClient()) {
            HitResult hitResult = player.raycast(50.0, 0.0f, false); // Reichweite 50 Blöcke

            if(hitResult.getType() == HitResult.Type.BLOCK) {
                Vec3d hitPos = hitResult.getPos();

                player.teleport(hitPos.x + 0.5, hitPos.y + 1.0, hitPos.z + 0.5);

                world.playSound(
                        null,
                        hitPos.x, hitPos.y, hitPos.z,
                        SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.0f
                );
            }
        }
    }
}