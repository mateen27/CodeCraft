import java.awt.*;
class Notepad{

	public static void main(String args[]){

	//Creating an Object of a Frame
	Frame frame = new Frame("Notepad");


	//TextArea for Frame
	TextArea txtArea = new TextArea();
	Font txtFont = new Font("Arial" , 1 , 24);
	Color txtBg = new Color(253, 253, 253);
	txtArea.setBackground(txtBg);
	txtArea.setFont(txtFont);
	frame.add(txtArea);


	//MenuBar for Frame
	MenuBar mb = new MenuBar();

	//Menu for Frame
	Menu file = new Menu("File");
	Menu edit = new Menu("Edit");
	Menu view = new Menu("View");
	Menu zoom = new Menu("Zoom");

	//MenuItem's for File
	MenuItem New = new MenuItem("New");
	MenuItem newWindow = new MenuItem("New Window");
	MenuItem open = new MenuItem("Open");
	MenuItem save = new MenuItem("Save");
	MenuItem saveAs = new MenuItem("Save as");
	MenuItem space = new MenuItem("-");
	MenuItem pageSetup = new MenuItem("Page setup");
	MenuItem print = new MenuItem("Print");
	MenuItem space2 = new MenuItem("-");
	MenuItem exit = new MenuItem("Exit");

	//MenuItem's for Edit
	MenuItem undo = new MenuItem("Undo");
	MenuItem space3 = new MenuItem("-");
	MenuItem cut = new MenuItem("Cut");
	MenuItem copy = new MenuItem("Copy");
	MenuItem paste = new MenuItem("Paste");
	MenuItem delete = new MenuItem("Delete");
	MenuItem space4 = new MenuItem("-");
	MenuItem find = new MenuItem("Find");
	MenuItem findNext = new MenuItem("Find next");
	MenuItem findPrevious = new MenuItem("Find Previous");
	MenuItem replace = new MenuItem("Replace");
	MenuItem Goto = new MenuItem("Go to");
	MenuItem space5 = new MenuItem("-");
	MenuItem selectAll = new MenuItem("Select all");
	MenuItem timeDate = new MenuItem("Time/Date");
	MenuItem space6 = new MenuItem("-");
	MenuItem font = new MenuItem("Font");

	//MenuItem's for View
	MenuItem status = new MenuItem("Status bar");
	MenuItem wordWrap = new MenuItem("Word wrap");
	//Zoom MenuItems
	MenuItem zoomIn = new MenuItem("Zoom in");
	MenuItem zoomOut = new MenuItem("Zoom out");
	MenuItem restore = new MenuItem("Restore default zoom");


	//Adding MenuItem to Menu
	file.add(New);
	file.add(newWindow);
	file.add(open);
	file.add(save);
	file.add(saveAs);
	file.add(space);
	file.add(pageSetup);
	file.add(print);
	file.add(space2);
	file.add(exit);

	//Adding MenuItem to Edit
	edit.add(undo);
	edit.add(space3);
	edit.add(cut);
	edit.add(copy);
	edit.add(paste);
	edit.add(delete);
	edit.add(space4);
	edit.add(find);
	edit.add(findNext);
	edit.add(findPrevious);
	edit.add(replace);
	edit.add(Goto);
	edit.add(space5);
	edit.add(selectAll);
	edit.add(timeDate);
	edit.add(space6);
	edit.add(font);

	//Adding MenuItem to View
	view.add(zoom);
		//Zoom MenuItem's
		zoom.add(zoomIn);
		zoom.add(zoomOut);
		zoom.add(restore);
	view.add(status);
	view.add(restore);

	

	//Adding Menu to the MenuBar
	mb.add(file);
	mb.add(edit);
	mb.add(view);




	//Adding MenuBar to the Frame
	frame.setMenuBar(mb);



	//Setting Frame Properties
	//frame.setLayout(null);
	frame.setSize(1100 , 600);
	frame.setVisible(true);
	}
}