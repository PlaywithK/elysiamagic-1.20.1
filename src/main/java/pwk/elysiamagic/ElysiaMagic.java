package pwk.elysiamagic;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pwk.elysiamagic.item.ModItemGroups;
import pwk.elysiamagic.item.ModItems;

public class ElysiaMagic implements ModInitializer {
	public static final String MOD_ID = "elysiamagic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}