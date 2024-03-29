import spock.lang.Specification

class BabySitterSpec extends Specification {

    def "calculateWage :: happy path"(int start, int bed, int end, int expected) {
        given:
        def wage = BabySitter.calculateWage(start, bed, end)

        expect:
        wage instanceof Integer
        wage == expected

        where:
        start   | bed   | end   | expected
        5       | 9     | 16    | 136
        10      | 11    | 12    | 20
        9       | 11    | 14    | 64
        6       | 6     | 10    | 32
        5       | 9     | 9     | 48
        7       | 8     | 9     | 20
    }

    def "it throws IllegalArgumentException for invalid inputs"(int start, int bed, int end) {
        when:
        BabySitter.calculateWage(start, bed, end)

        then:
        thrown(IllegalArgumentException)

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

