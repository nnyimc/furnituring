package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Maquette extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree catalogTree;
	private JPanel contentPane;
	private JTable furnitureTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maquette frame = new Maquette();
					frame.setSize(600, 800);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Maquette() {
		setTitle("Furnituring");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu(" File / Fichier");
		menuBar.add(mnFile);
		
		JMenuItem newMenuItem = new JMenuItem("New / Nouveau");
		mnFile.add(newMenuItem);
		
		JMenuItem openMenuItem = new JMenuItem("Open... / Ouvrir...");
		mnFile.add(openMenuItem);
		
		JMenuItem closeMenuItem = new JMenuItem("Close / Fermer");
		mnFile.add(closeMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save / Enregistrer");
		mnFile.add(saveMenuItem);
		
		JMenuItem preferencesMenuItem = new JMenuItem("Preferences / Pr\u00E9f\u00E9rences");
		mnFile.add(preferencesMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit / Quitter");
		mnFile.add(exitMenuItem);
		
		JMenu mnEdit = new JMenu("Edit / Edition");
		menuBar.add(mnEdit);
		
		JMenuItem undoMenuItem = new JMenuItem("Undo / Annuler");
		mnEdit.add(undoMenuItem);
		
		JMenuItem redoMenuItem = new JMenuItem("Redo / Refaire");
		mnEdit.add(redoMenuItem);
		
		JMenuItem cutMenuitem = new JMenuItem("Cut / Couper");
		mnEdit.add(cutMenuitem);
		
		JMenuItem copyMenuItem = new JMenuItem("Copy / Copier");
		mnEdit.add(copyMenuItem);
		
		JMenuItem pasteMenuItem = new JMenuItem("Paste / Coller");
		mnEdit.add(pasteMenuItem);
		
		JMenuItem deleteMenuItem = new JMenuItem("Delete / Supprimer");
		mnEdit.add(deleteMenuItem);
		
		JMenu mnFurniture = new JMenu("Furniture / Meuble");
		menuBar.add(mnFurniture);
		
		JMenuItem addMenuItem = new JMenuItem("Add / Ajouter");
		mnFurniture.add(addMenuItem);
		
		JMenu mnPlan = new JMenu("Plan");
		menuBar.add(mnPlan);
		
		JMenuItem mntmCreateWalls = new JMenuItem("Create walls / Cr\u00E9er les murs");
		mnPlan.add(mntmCreateWalls);
		
		JMenuItem importMenuItem = new JMenuItem("Import image...");
		mnPlan.add(importMenuItem);
		
		JMenu mnHelp = new JMenu("Help / Aide");
		menuBar.add(mnHelp);
		
		JMenuItem helpMenuItem = new JMenuItem("Furnituring help / Aide de Furnituring");
		mnHelp.add(helpMenuItem);
		
		JMenuItem mntmAbout = new JMenuItem("About... / \u00C0 propos de...");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane mainSplitPane = new JSplitPane();
		mainSplitPane.setResizeWeight(0.3);
		mainSplitPane.setBackground(Color.WHITE);
		contentPane.add(mainSplitPane, BorderLayout.CENTER);
		
		JSplitPane leftSplitPane = new JSplitPane();
		leftSplitPane.setResizeWeight(0.5);
		leftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPane.setLeftComponent(leftSplitPane);
		
		JScrollPane topLeftScrollPane = new JScrollPane();
		leftSplitPane.setLeftComponent(topLeftScrollPane);
		
		JTree catalogTree = getCatalogTree();
		topLeftScrollPane.setViewportView(catalogTree);
		
		JScrollPane bottomLeftScrollPane = new JScrollPane();
		leftSplitPane.setRightComponent(bottomLeftScrollPane);
		
		furnitureTable = getFurnitureTable();
		bottomLeftScrollPane.setViewportView(furnitureTable);
		
		JSplitPane rightSplitPane = new JSplitPane();
		rightSplitPane.setResizeWeight(0.5);
		rightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPane.setRightComponent(rightSplitPane);
		
		JScrollPane topRightScrollPane = new JScrollPane();
		rightSplitPane.setLeftComponent(topRightScrollPane);
		
		JLabel planLabel = new JLabel("");
		planLabel.setBackground(Color.WHITE);
		planLabel.setIcon(new ImageIcon("J:\\eWorkspace\\Furnituring\\resources\\view_2D.jpg"));
		topRightScrollPane.setViewportView(planLabel);
		
		JScrollPane bottomRightScrollPane = new JScrollPane();
		rightSplitPane.setRightComponent(bottomRightScrollPane);
		
		JLabel view3DLabel = new JLabel("");
		view3DLabel.setBackground(Color.WHITE);
		view3DLabel.setIcon(new ImageIcon("J:\\eWorkspace\\Furnituring\\resources\\view_3D.jpg"));
		bottomRightScrollPane.setViewportView(view3DLabel);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnCutbutton = new JButton("");
		btnCutbutton.setIcon(new ImageIcon("J:\\eWorkspace\\Furnituring\\resources\\ct.png"));
		toolBar.add(btnCutbutton);
		
		JButton btnCopyButton = new JButton("");
		btnCopyButton.setIcon(new ImageIcon("J:\\eWorkspace\\Furnituring\\resources\\cpy.png"));
		toolBar.add(btnCopyButton);
		
		JButton pasteButton = new JButton("");
		pasteButton.setIcon(new ImageIcon("J:\\eWorkspace\\Furnituring\\resources\\pst.png"));
		toolBar.add(pasteButton);
	}
	
	private JTree getCatalogTree() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (null == catalogTree) {
			DefaultMutableTreeNode bedroom = 
					new DefaultMutableTreeNode("Bedroom");
			bedroom.add(new DefaultMutableTreeNode("Bed 90 x 190"));
			bedroom.add(new DefaultMutableTreeNode("Oak Chest"));
			bedroom.add(new DefaultMutableTreeNode("Bedside table"));
			
			DefaultMutableTreeNode livingRoom = 
					new DefaultMutableTreeNode("Living room");
			livingRoom.add(new DefaultMutableTreeNode("Bookcase"));
			livingRoom.add(new DefaultMutableTreeNode("Armchair"));
			livingRoom.add(new DefaultMutableTreeNode("Coffee table"));
			
			DefaultMutableTreeNode furnitureRoot = 
					new DefaultMutableTreeNode();
			furnitureRoot.add(bedroom);
			furnitureRoot.add(livingRoom);
			
			catalogTree = new JTree(furnitureRoot);
			catalogTree.setRootVisible(false);
			catalogTree.setShowsRootHandles(true);
		}
		return catalogTree;
	}
	
	private JTable getFurnitureTable() {
		if (null == furnitureTable) {
			Object [] columns = {"Name", "Width", "Depth", "Heigth"};
			Object [][] data = { 
								{"Bed", 90, 190, 75 },
								{"Oak Chest", 100, 90, 90 },
								{"Table", 80, 60, 45 },
								{"Armchair", 70, 90, 90 },
								{"Bookcase", 80, 40, 190 }
			};
			furnitureTable = new JTable(data, columns);
			
		}
		return furnitureTable;
	}
	
	

}
