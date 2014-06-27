package showview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowHandler implements IHandler {
	ShowViewPart viewpart;
	ISelection selection;
	Object firstElement;
	String[] graphStringData;
	ArrayList<Integer> graphDataList = new ArrayList<Integer>();

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
		Init_Graph(event);
		IFile file = getSelectedFile(event);
		String csvData = ReadFile(file);
		graphStringData = csvData.split(",", 0);

		for (int i = 0; i < graphStringData.length; i++) {
			graphDataList.add(Integer.parseInt(graphStringData[i]));
		}

		viewpart.setSelection(graphDataList.get(0));


//		viewpart.setSelection(graphIntegerData[0]);
		return null;
	}

	private void Init_Graph(ExecutionEvent event) {
		viewpart = null;

		// 起動中のワークベンチのウィンドウを全て取得
		IWorkbenchWindow[] views = PlatformUI.getWorkbench()
				.getWorkbenchWindows();
		for (IViewReference view : views[0].getActivePage().getViewReferences()) {
			if (view.getId().equals(ShowViewPart.ID)) {
				viewpart = (ShowViewPart) view.getView(true);
			}
		}
	}

	private IFile getSelectedFile(ExecutionEvent event) {
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);
		Object firstElement = currentSelection.getFirstElement();
		if (!(firstElement instanceof IFile)) {
			firstElement = null;
		}

		return (IFile) firstElement;
	}

	private String ReadFile(IFile file) {
		if (file != null) {
			try {
				File f = new File(file.getLocationURI());
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String s;
				String str = "";
				while ((s = br.readLine()) != null) {
					str += s;
					str += ",";
				}
				br.close();
				return str;
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return "";

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
