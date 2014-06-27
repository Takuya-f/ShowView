package showview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.part.ViewPart;

public class ShowViewPart extends ViewPart {
	public static final String ID = "ShowView.view1";

	private Label label;
	private ProgressBar bar;

	public ShowViewPart() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO 自動生成されたメソッド・スタブ
		parent.setLayout(new GridLayout(1,true));
		label = new Label(parent, SWT.NONE);
		label.setText("No data yet.");
		bar = new ProgressBar(parent, SWT.SMOOTH);
		bar.setMinimum(0);
		bar.setMaximum(100);
	}

	@Override
	public void setFocus() {
		// TODO 自動生成されたメソッド・スタブ
	}

	public void setSelection(int value){
		label.setText(Integer.toString(value)+"%");
		bar.setSelection(value);
	}
}
