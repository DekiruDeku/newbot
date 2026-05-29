package com.justai.jaicf.template.scenario

import com.justai.jaicf.builder.Scenario

val mainScenario = Scenario {

    state("hello", noContext = true) {
        activators {
            regex("""(?iu).*(привет|здравствуй|здравствуйте|добрый\s+день|доброе\s+утро|добрый\s+вечер|hello|hi|старт|помощь|что\s+ты\s+умеешь).*""")
        }

        action {
            reactions.say("Привет! Я бот-помощник. Я могу рассказать о погоде и курсе валют. Напишите: «погода» или «курс валют».")
        }
    }

    state("weather", noContext = true) {
        activators {
            regex("""(?iu).*(погод|прогноз|температур|дожд|снег|weather).*""")
        }

        action {
            reactions.say("Сегодня ожидается переменная облачность, температура около +20°C. Это учебный прогноз. Для точного прогноза обычно нужно указать город.")
        }
    }

    state("currency", noContext = true) {
        activators {
            regex("""(?iu).*(курс|валют|доллар|евро|usd|eur|exchange|currency).*""")
        }

        action {
            reactions.say("Примерный курс валют: доллар — 90 рублей, евро — 98 рублей. Это учебные данные для демонстрации работы бота.")
        }
    }

    state("NoMatch", noContext = true) {
        action {
            reactions.say("Извините, я не понял запрос. Я умею отвечать на приветствие, запрос погоды и курс валют. Попробуйте написать: «привет», «погода» или «курс валют».")
        }
    }

    fallback {
        reactions.go("/NoMatch")
    }
}