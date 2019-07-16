import spock.lang.Specification

class BabySitterSpec extends Specification {
    def babysitter = new BabySitter()

    def "happy path :: it returns an int"(int start, int bed, int end) {
        given:
        def wage = babysitter.calculateWage(start, bed, end)

        expect:
        wage instanceof Integer

        where:
        start   | bed   | end
        5       | 9     | 16
        5       | 9     | 9
        6       | 6     | 10
        7       | 8     | 9
        10      | 11    | 12
    }

    def "it validates inputs"(int start, int bed, int end) {
        given:
        def wage = babysitter.calculateWage(start, bed, end)

        expect:
        wage == -1

        where:
        start   | bed   | end
        0       | 0     | 0
        4       | 9     | 14
        6       | 5     | 12
        6       | 14    | 12
        5       | -1    | 13
        9       | 12    | 200
    }
}

