package cf.hydos.noTutorialToast.mixin;

import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.TutorialToast;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TutorialToast.class)
public class TutorialToastMixin {

	@Inject(at = @At("HEAD"), method = "render", cancellable = true)
	private void hideToastInstantly(CallbackInfoReturnable<Toast.Visibility> cir) {
		cir.setReturnValue(Toast.Visibility.HIDE);
	}
}
