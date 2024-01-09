package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import entities.Item;

import java.io.FileReader;
import java.io.FileWriter;

public class Program {

	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		
		try (
				BufferedReader br = new BufferedReader(new FileReader("")); // "c:\\pastaexemplo\\aquivo.csv"
				BufferedWriter newBr = new BufferedWriter(new FileWriter("")); // "c:\\pastaexemplo\\out\\aquivo.csv"
			) {
			
			String line = br.readLine();
			
			String name;
			Double price;
			int quantity;
			
			while(line != null) {
				name = line.split(",")[0];
				price = Double.parseDouble(line.split(",")[1]);
				quantity = Integer.parseInt(line.split(",")[2]);
				items.add(new Item(name, price, quantity));
				line = br.readLine();
			}
			
			for(Item item: items) {
				String outputLine = String.format("%s,%.2f", item.getName(), item.calculateTotal());
				newBr.write(outputLine);
				newBr.newLine();
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}