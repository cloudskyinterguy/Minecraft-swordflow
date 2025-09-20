package com.ytnz.swordflow;

import com.ytnz.robe.TaoistRobeModel;
import com.ytnz.robe.TaoistRobeRenderLayer;
import com.ytnz.robe.TaoistRobeRenderState;
import com.ytnz.sword.SwordCurve;
import com.ytnz.sword.SwordModel;
import com.ytnz.registries.EntityRegsitries;
import com.ytnz.sword.Sword;
import com.ytnz.sword.SwordEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.ArrayList;
import java.util.List;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = SwordFlow.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = SwordFlow.MODID, value = Dist.CLIENT)
public class SwordFlowClient {

    public SwordFlowClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        SwordFlow.LOGGER.info("HELLO FROM CLIENT SETUP");
        SwordFlow.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    static void registerSwordRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegsitries.SWORD_ENTITY_TYPE.get(), SwordEntityRenderer::new);
    }


    @SubscribeEvent
    static void registerModelLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        //剑模型注册
        event.registerLayerDefinition(SwordModel.SWORD_MODEL_LAYER_KEY,SwordModel::createBodyLayer);
        //道袍模型注册
        event.registerLayerDefinition(TaoistRobeModel.TAOIST_ROBE_MODEL_KEY,TaoistRobeModel::createTaoistLayer);
    }

    @SubscribeEvent
    static void addPlayerRenderlayer(EntityRenderersEvent.AddLayers event) {
        for (PlayerSkin.Model skinName : event.getSkins()) {
            PlayerRenderer renderer = event.getSkin(skinName);
            if (renderer != null) {
                // 添加自定义渲染层
                renderer.addLayer(new TaoistRobeRenderLayer((RenderLayerParent) renderer,event.getEntityModels()));
            }
        }
    }
}
