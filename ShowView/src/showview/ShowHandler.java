package showview;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ShowHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO 自動生成されたメソッド・スタブ

		ShowViewPart viewpart = null;
		int value = 30;

		IWorkbenchWindow[] views = PlatformUI.getWorkbench().getWorkbenchWindows();//起動中のワークベンチのウィンドウを全て取得
		for(IViewReference view:views[0].getActivePage().getViewReferences()){
			if(view.getId().equals(ShowViewPart.ID)){
				viewpart = (ShowViewPart)view.getView(true);
			}
		}

		if(viewpart != null){
			viewpart.setSelection(value);
		}

		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
