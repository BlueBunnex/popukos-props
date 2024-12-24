package net.bluebunnex.pixelgirls;

import net.bluebunnex.pixelgirls.entity.WomanEntity;
import net.bluebunnex.pixelgirls.entity.WomanEntityModel;
import net.bluebunnex.pixelgirls.item.SlimeHammer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class PixelGirls {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item slimeHammer;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {

        slimeHammer = new SlimeHammer(NAMESPACE.id("slime_hammer")).setTranslationKey(NAMESPACE, "slime_hammer");
    }

    @EventListener
    public void registerEntities(EntityRegister event) {

        event.register(WomanEntity.class, "Woman");
    }

    @EventListener
    public void registerEntityRenderer(EntityRendererRegisterEvent event) {

        event.renderers.put(WomanEntity.class, new LivingEntityRenderer(new WomanEntityModel(), 1));
    }
}