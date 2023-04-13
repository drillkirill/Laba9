public class Zad12 {
    public static void main(String[] args) {

        String[] letter = {
                "Эй, депутатик! Я дед, пишу тебе не первый раз.",
                "Значит так, будем говорить о твоей работе.",
                "Короче, я тут смотрю по телевизору новости,",
                "и видимо, ты как-то умудрился с этим ФЗ-230 связаться.",
                "Типа, ты его написал, а там половина слов не те,",
                "что нужно. Ну короче, мужчинка, разберись уже!",
                "Чтобы этого больше не происходило,",
                "я думаю, ты должен провести курсы повышения квалификации."};

        String[] duplicates = {" +", " +", " +", " +"};
        String[] parasites = {"будем говорить", "ну", "значит так", "короче", "типа"};
        String[] substitutions = {"Алексей Геннадьевич", "Алексей Геннадьевич", "Алексей Геннадьевич", "Алексей Геннадьевич"};
        String[] wrongAddressings = {"эй", "депутатик", "мужчинка", "сынок"};

        for (String line : letter) {
            String correctedLine = line;
            for (int i = 0; i < duplicates.length; i++) {
                correctedLine = correctedLine.replaceAll(duplicates[i], " ");
            }
            for (int i = 0; i < parasites.length; i++) {
                correctedLine = correctedLine.replaceAll("\\b" + parasites[i] + "\\b", "").trim();
            }
            for (int i = 0; i < substitutions.length; i++) {
                correctedLine = correctedLine.replaceAll(substitutions[i], "Алексей Геннадьевич");
            }
            for (int i = 0; i < wrongAddressings.length; i++) {
                correctedLine = correctedLine.replaceAll("\\b" + wrongAddressings[i] + "\\b", "Алексей Геннадьевич");
            }
            System.out.println(line);
            System.out.println(correctedLine);
        }
    }
}