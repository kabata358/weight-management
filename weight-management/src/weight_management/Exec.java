package weight_management;

import java.util.Scanner;

public class Exec {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//// BMI 算出
		double height, weight, bmi;
		
		// 情報入力
		System.out.println("身長(cm)を入力してください。");
		System.out.print("      -> ");
		height = scanner.nextDouble();
		System.out.println("体重(kg)を入力してください。");
		System.out.print("      -> ");
		weight = scanner.nextDouble();
		
		// BMI を算出
		bmi = weight / Math.pow(height / 100, 2);
		System.out.println("BMI ：　" + bmi);
		
		//// マクロバランスを算出
		int gender, age, activity, goal;
		double correction, basalMetabolism, magnification, totalCalories, caloriesBurned, protein, fat, carbohydrate;
		
		// 情報入力
		System.out.println("性別を入力してください。");
		System.out.println("  [1] 男性");
		System.out.println("  [2] 女性");
		System.out.print("      -> ");
		gender = scanner.nextInt();
		System.out.println("年齢を入力してください。");
		System.out.print("      -> ");
		age = scanner.nextInt();
		System.out.println("活動指標を選択してください。");
		System.out.println("  [1] 座り仕事が多く、一日の運動は偶に歩いたり階段を上ったりする程度である");
		System.out.println("  [2] 立ち仕事や重労働が多く、比較的一日中動き回っている");
		System.out.println("  [3] 立ち仕事や重労働が多く、それに加えてジムでトレーニングを行ったり運動している");
		System.out.print("      -> ");
		activity = scanner.nextInt();
		System.out.println("目的を選択してください。");
		System.out.println("  [1] 減量");
		System.out.println("  [2] 維持");
		System.out.println("  [3] 増量");
		System.out.print("      -> ");
		goal = scanner.nextInt();
		
		// 基礎代謝を計算
		if(gender == 1) {
			correction = 5;
		} else {
			correction = -161;
		}
		
		basalMetabolism = 10 * weight + 6.25 * height - 5 * age + correction;
		
		// 一日の消費カロリーを計算
		if(activity == 1) {
			magnification = 1.2;
		} else if(activity == 2) {
			magnification = 1.55;
		} else {
			magnification = 1.725;
		}
		
		caloriesBurned = basalMetabolism * magnification;
		
		// 総摂取カロリーを計算
		if(goal == 1) {
			magnification = 0.8;
		} else if(goal == 2) {
			magnification = 1.0;
		} else {
			magnification = 1.2;
		}
		
		totalCalories = caloriesBurned * magnification;
		
		// マクロバランスを算出
		protein = weight * 2;
		fat = totalCalories * 0.25 / 9;
		carbohydrate = (totalCalories - (protein * 4 + fat * 9)) / 4;
		
		System.out.println("基礎代謝 ：　" + basalMetabolism + "kcal");
		System.out.println("一日の消費カロリー ：　" + caloriesBurned + "kcal");
		System.out.println("総摂取カロリー ：　" + totalCalories + "kcal");
		System.out.println("タンパク質 ：　" + protein + "g");
		System.out.println("炭水化物 ：　" + carbohydrate + "g");
		System.out.println("脂質 ：　" + fat + "g");
		
		//// 減量シミュレーション
		double goalWeight, weightLoss;
		
		System.out.println("目標体重(kg)を入力してください。");
		System.out.print("      -> ");
		goalWeight = scanner.nextDouble();
		System.out.println("一日の減量(kg)を入力してください。");
		System.out.print("      -> ");
		weightLoss = scanner.nextDouble();
		
		System.out.println("毎日" + weightLoss + "kgを減量した場合、目標体重" + goalWeight + "kg まで、あと" + (int)((weight - goalWeight) / weightLoss) + "日 です。");
		
	}

}
