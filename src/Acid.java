/*
A. Андрей и кислота
Ограничение времени	2 секунды
Ограничение памяти	512Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Андрей работает в секретной химической лаборатории, в которой производят опасную кислоту с удивительными свойствами. У Андрея есть
n бесконечно больших резервуаров, расположенных в один ряд. Изначально в каждом резервуаре находится некоторое количество кислоты.
Начальство Андрея требует, чтобы во всех резервуарах содержался одинаковый объем кислоты. К сожалению, разливающий аппарат несовершенен.
За одну операцию он способен разлить по одному литру кислоты в каждый из первых k (1≤k≤n) резервуаров. Обратите внимание, что для разных операций
k могут быть разными. Поскольку кислота очень дорогая, Андрею не разрешается выливать кислоту из резервуаров. Андрей просит вас узнать, можно ли уравнять объемы кислоты в резервуарах, и, если это возможно, то посчитать минимальное количество операций, которое потребуется, чтобы этого достичь.
Формат ввода
Первая строка содержит число n (1≤n≤100000) — количество резервуаров.
Во второй строке содержатся n елых чисел ai (1≤ai≤10^9), где ai означает исходный объём кислоты в iм резервуаре в литрах.

Формат вывода
Если объемы кислоты в резервуарах можно уравнять, выведите минимальное количество операций, необходимых для этого.
Если это невозможно, выведите «-1».
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Acid {

    public static void main(String args[]) {

        try {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            List<Integer> tanks = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                tanks.add(sc.nextInt());
            }

            int maxTank = Collections.max(tanks);
            List<Integer> lessFilled = new ArrayList<Integer>();

            for (int i = 0; i < tanks.size(); i++) {
                if (tanks.get(i) < maxTank) {
                    lessFilled.add(tanks.get(i));
                }
            }

            Integer result = -1;
            List<Integer> lessFilledSorted = List.copyOf(lessFilled);
            Collections.sort(lessFilledSorted);
            if (lessFilled.size() == 0) {
                result = 0;
            } else if (lessFilled.equals(lessFilledSorted)) {
                result = maxTank - lessFilled.get(0);
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

