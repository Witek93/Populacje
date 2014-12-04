package populacje;

public class Symulacja {

//    final private List<Point> wolnePola;
//    final private List<Rabbit> kroliki;
//    final private List<Wolf> wilki;

//    public Symulacja() {
//        this.kroliki = new LinkedList();
//        this.wilki = new LinkedList();
//        wolnePola = new ArrayList();
//        for (int i = 0; i < Parameters.getInstance().getMapWidth(); i++) {
//            for (int j = 0; j < Parameters.getInstance().getMapHeight(); j++) {
//                wolnePola.add(new Point(i, j));
//            }
//        }
//
//        for (int i = 0; i < Parameters.getInstance().getRabbitsCount(); i++) {
//            Random los = new Random();
//            int index = los.nextInt(wolnePola.size());
//            kroliki.add(new Rabbit(wolnePola.get(index)));
//            wolnePola.remove(index);
//        }
//
//        for (int i = 0; i < Parameters.getInstance().getWolvesCount(); i++) {
//            Random los = new Random();
//            int index = los.nextInt(wolnePola.size());
//            wilki.add(new Wolf(wolnePola.get(index)));
//            wolnePola.remove(index);
//        }
//    }

    public void przemiescKroliki() {
//        for (Rabbit elem : kroliki) {
//            int poprzedniX = elem.getPoint().x;
//            int poprzedniY = elem.getPoint().y;
//            Random gen = new Random();
//            int newX = elem.getPoint().x + gen.nextInt(3) - 1;
//            int newY = elem.getPoint().y + gen.nextInt(3) - 1;
//
//            if (newX >= 0 
//                    && newX < Parameters.getInstance().getMapWidth() 
//                    && newY >= 0
//                    && newY < Parameters.getInstance().getMapHeight() 
//                    && Map.getInstance().isFree(newY, newY)) {
//                wolnePola.add(new Point(poprzedniX, poprzedniY));
//                Map.getInstance().setCell(poprzedniX, poprzedniY, null);
//                elem.movePoint(new Point(newX, newY));
//                Map.getInstance().setCell(newX, newY, new Rabbit(new Point(newX, newY)));
//            }
//        }
    }

    public void przemiescWilki() {
//        Iterator<Wolf> itr = wilki.listIterator();
//        while (itr.hasNext()) {
//            Wolf elem = itr.next();
//            Random gen = new Random();
//            int poprzedniX = elem.getPoint().x;
//            int poprzedniY = elem.getPoint().y;
//            int newX = poprzedniX + gen.nextInt(11) - 5;
//            int newY = poprzedniY + gen.nextInt(11) - 5;
//
//            // jeśli wylosowane nowe miejsce jest wolne
//            if (newX >= 0 && newX < Parameters.getInstance().getMapWidth() && newY >= 0
//                    && newY < Parameters.getInstance().getMapHeight()) {
//                //oznacz stare pole jako wolne
//                wolnePola.add(new Point(poprzedniX, poprzedniY));
//                //TODO usunąć na rzecz nowej funkcji typu mapa.move(Animal a, Direction d)  
//                Map.getInstance().setCell(poprzedniX, poprzedniY, null);
//                // i przemiesc wilka
//                elem.movePoint(new Point(newX, newY));
//                Map.getInstance().setCell(newX, newY, new Wolf(new Point(newX, newY)));
//                elem.incGlod();
//                // sprawdz czy wilk natrafil na krolika
//                for (Rabbit ofiara : kroliki) {
//                    if (ofiara.getPoint().x == newX && ofiara.getPoint().y == newY) {
//                        kroliki.remove(ofiara);
//                        elem.decGlod();
//                        break;
//                    }
//                }
//            }
//
//            // wygłodniałe wilki po 30 dniach umierają
//            if (elem.getGlod() == 60 && itr.hasNext()) {
//                itr.next();
//                itr.remove();
//                wolnePola.add(new Point(poprzedniX, poprzedniY));
//                Map.getInstance().setCell(poprzedniX, poprzedniY, null);
//            }
//        }
    }

    void rozmnazajKroliki() {
//        int liczbaPlodnych = 0;
//        for (Rabbit krolik : kroliki) {
//            // zwiekszamy wiek krolikow o 1/3 roku = zakladamy ze wszystkie plodne kroliki rozmnazaja sie 3 razy w roku
//            krolik.setAge(krolik.getAge() + 0.33);
//            if (krolik.getAge() > 0.5) {
//                liczbaPlodnych++;
//            }
//        }
//        int pary = liczbaPlodnych / 2;
//        for (int i = 0; i < pary; i++) {
//            Random gen = new Random();
//            int potomstwo = gen.nextInt(4) + 2;
//            for (int j = 0; j < potomstwo; j++) {
//                if (!wolnePola.isEmpty() && kroliki.size() < 2000) {
//                    kroliki.add(new Rabbit(wolnePola.get(0)));
//                    wolnePola.remove(0);
//                }
//            }
//        }
    }

    void rozmnazajWilki() {
//        int liczbaPlodnych = 0;
//        for (Wolf wilk : wilki) {
//            // zwiekszamy wiek wilkow o 1 rok - zakladamy ze wszystkie plodne wilki rozmnazaja sie co roku
//            wilk.setAge(wilk.getAge() + 1);
//            if (wilk.getAge() >= 2.0) {
//                liczbaPlodnych++;
//            }
//        }
//        int pary = liczbaPlodnych / 2;
//        for (int i = 0; i < pary; i++) {
//            Random gen = new Random();
//            int potomstwo = gen.nextInt(8) + 4;
//            for (int j = 0; j < potomstwo; j++) {
//                if (!wolnePola.isEmpty() && wilki.size() < 250) {
//                    wilki.add(new Wolf(wolnePola.get(0)));
//                    wolnePola.remove(0);
//                }
//            }
//        }
    }

    public void stareKroliki() {
//        Iterator<Rabbit> itr = kroliki.listIterator();
//        while (itr.hasNext()) {
//            Rabbit elem = itr.next();
//            if (elem.getAge() == 5 && itr.hasNext()) {
//                int x = elem.getPoint().x;
//                int y = elem.getPoint().y;
//                itr.next();
//                itr.remove();
//                wolnePola.add(new Point(x, y));
//                Map.getInstance().setCell(x, y, null);
//            }
//        }
    }

    public void stareWilki() {
//        Iterator<Wolf> itr = wilki.listIterator();
//        while (itr.hasNext()) {
//            Wolf elem = itr.next();
//            if (elem.getAge() == 10 && itr.hasNext()) {
//                int x = elem.getPoint().x;
//                int y = elem.getPoint().y;
//                itr.next();
//                itr.remove();
//                wolnePola.add(new Point(x, y));
//                Map.getInstance().setCell(x, y, null);
//            }
//        }
    }

    // jedno wywołanie funkcji to okres 1 roku zycia populacjii
    public void symuluj() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 122; j++) {
                przemiescKroliki();
                przemiescWilki();
            }
            rozmnazajKroliki();
        }
        rozmnazajWilki();
        stareKroliki();
        stareWilki();
    }


}
