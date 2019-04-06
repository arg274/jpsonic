package com.tesshu.jpsonic.service.search.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.AbstractAnalysisFactory;
import org.apache.lucene.analysis.util.MultiTermAwareComponent;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;

public class HiraganaTermStemFilterFactory extends TokenFilterFactory implements MultiTermAwareComponent {

    private static final String PASSABLE_ONLY_ALL_HIRAGANA = "passableOnlyAllHiragana";

    private final boolean passableOnlyAllHiragana;

    public HiraganaTermStemFilterFactory(Map<String, String> args) {
        super(args);
        passableOnlyAllHiragana = getBoolean(args, PASSABLE_ONLY_ALL_HIRAGANA, false);
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters: " + args);
        }
    }

    @Override
    public HiraganaTermStemFilter create(TokenStream input) {
        return new HiraganaTermStemFilter(input, passableOnlyAllHiragana);
    }

    @Override
    public AbstractAnalysisFactory getMultiTermComponent() {
        return this;
    }

}
