package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import metier.Catalog;
import metier.CatalogPieceOfFurniture;
import metier.Category;
import persistance.DefaultCatalog;
import presentation.CatalogTree;

class CatalogTreeTest extends TestCase {

	
	@Test
	void test() {
		Locale.setDefault(Locale.US);
		
		Catalog catalog = new DefaultCatalog();
		List<Category> categories = catalog.getCategories();
		Category firstCategory = categories.get(0);
		String firstCategoryEnglishName = firstCategory.getName();
		
		List<CatalogPieceOfFurniture> categoryFurniture = firstCategory.getFurniture();
		CatalogPieceOfFurniture firstPiece = categoryFurniture.get(0);
		String firstPieceEnglishName = firstPiece.getName();
		
		Locale.setDefault(Locale.FRANCE);
		catalog = new DefaultCatalog();
		
		firstCategory = catalog.getCategories().get(0);
		String firstCategoryFrenchName = firstCategory.getName();
		
		firstPiece = firstCategory.getFurniture().get(0);
		String firstPieceFrenchName = firstPiece.getName(); 
		
		assertFalse(
				"Same name for first category", 
				firstCategoryEnglishName.contentEquals(firstCategoryFrenchName)
				);
		
		assertFalse(
				"Same name for first piece",
				firstPieceEnglishName.equals(firstPieceFrenchName)
				);
		
		
		JTree tree = new CatalogTree(catalog);
		
		assertFalse(
				"Root is visible",
				tree.isRootVisible()
				);
		
		assertFalse(
				"Handles are hidden",
				tree.getShowsRootHandles()
				);

	}
	
	
	public void assertTreeIsSorted(JTree tree) {
		fail("assertTreeIsSorted not implemented");
	}
	
	
	public static void main(String[] args) {
		CatalogTree tree = new CatalogTree(new DefaultCatalog());
		JFrame frame = new JFrame("Catalog Tree Test");
		frame.add(new JScrollPane(tree));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	

}
