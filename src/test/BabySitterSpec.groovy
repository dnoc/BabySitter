import spock.lang.Specification

class BabySitterSpec extends Specification {
    def babysitter = new BabySitter()

    def "It returns an int"(int start, int bed, int end) {
        given:
        def wage = babysitter.calculateWage(start, bed, end)

        expect:
        wage instanceof Integer

        where:
        start   | bed   | end
        0       | 0     | 0
        5       | 9     | 14
        4       | -1    | 0
        20      | 25    | 5
        252     | 105   | 21
    }
}

