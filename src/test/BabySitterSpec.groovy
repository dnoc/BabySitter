import spock.lang.Specification

class BabySitterSpec extends Specification {
    def babysitter = new BabySitter()

    def "It returns an int"() {
        given:
        def wage = babysitter.calculateWage()

        expect:
        wage instanceof Integer
    }
}

