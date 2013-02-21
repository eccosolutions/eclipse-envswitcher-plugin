package org.eccosolutions.eclipse.envswitcher.preferences;

import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

/**
 * A field editor to edit strings
 */
public class StringListEditor extends ListEditor {


    private static final String SEP = "\r";

    private String dialogText;

    protected StringListEditor() {
    }

    /**
     * Creates a path field editor.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param labelText the label text displayed dialog
     * @param parent the parent of the field editor's control
     */
    public StringListEditor(String name, String labelText,
            String dialogText, Composite parent) {
        init(name, labelText);
        this.dialogText = dialogText;
        createControl(parent);
    }

    protected String createList(String[] items) {
        StringBuffer path = new StringBuffer("");//$NON-NLS-1$

        for (int i = 0; i < items.length; i++) {
            path.append(items[i]);
            path.append(SEP);
        }
        return path.toString();
    }

    /* (non-Javadoc)
     * Method declared on ListEditor.
     * Creates a new path element by means of a directory dialog.
     */
    protected String getNewInputObject() {

    	MessageBox dialog = new MessageBox(getShell(), SWT.SHEET);
        if (dialogText != null) {
			dialog.setMessage(dialogText);
		}
        int res = dialog.open();
        return dialog.getText();
    }

    /* (non-Javadoc)
     * Method declared on ListEditor.
     */
    protected String[] parseString(String stringList) {
    	return stringList.split("[\r\n]");//$NON-NLS-1$
    }
}
