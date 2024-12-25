package StrategyPattern;
import Interfaces.IAlgoPatternMatching;
import Test.IAlgoPatternMatchingTest;

// File: PatternMatchingContext.java
public class PatternMatchingContext
{
    private IAlgoPatternMatching strategy;

    // Set the strategy dynamically
    public void setStrategy(IAlgoPatternMatching strategy)
    {
        this.strategy = strategy;
    }

    // Perform the search using the current strategy
    public int search(String text, String pattern) {
        return strategy.search(text, pattern);
    }
}
