package me.bread.banking;

import me.bread.banking.domain.Money;
import me.bread.banking.view.model.BodyModel;
import me.bread.banking.view.BodyView;
import me.bread.banking.view.HeaderView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printHeaderOk() {
        HeaderView.print();

        String expectedOutput = "date       || credit   || debit    || balance  \n";

        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void printBodyOk() {
        BodyView.print(
                new BodyModel(
                        Optional.of("14/01/2012"),
                        Optional.empty(),
                        Optional.of(new Money(new BigDecimal("500"), Currency.getInstance(Locale.US))),
                        Optional.of(new Money(new BigDecimal("2500"), Currency.getInstance(Locale.US)))
                )
        );

        String expectedOutput =
                "14/01/2012 ||          || 500.00   || 2500.00  \n";

        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void printAllOk() {
        HeaderView.print();

        BodyView.print(
                new BodyModel(
                        Optional.of("14/01/2012"),
                        Optional.empty(),
                        Optional.of(new Money(new BigDecimal("500"), Currency.getInstance(Locale.US))),
                        Optional.of(new Money(new BigDecimal("2500"), Currency.getInstance(Locale.US)))
                )
        );
        BodyView.print(
                new BodyModel(
                        Optional.of("13/01/2012"),
                        Optional.of(new Money(new BigDecimal("2000"), Currency.getInstance(Locale.US))),
                        Optional.empty(),
                        Optional.of(new Money(new BigDecimal("3000"), Currency.getInstance(Locale.US)))
                )
        );
        BodyView.print(
                new BodyModel(
                        Optional.of("10/01/2012"),
                        Optional.of(new Money(new BigDecimal("1000"), Currency.getInstance(Locale.US))),
                        Optional.empty(),
                        Optional.of(new Money(new BigDecimal("1000"), Currency.getInstance(Locale.US)))
                )
        );

        String expectedOutput =
                "date       || credit   || debit    || balance  \n" +
                        "14/01/2012 ||          || 500.00   || 2500.00  \n" +
                        "13/01/2012 || 2000.00  ||          || 3000.00  \n" +
                        "10/01/2012 || 1000.00  ||          || 1000.00  \n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
