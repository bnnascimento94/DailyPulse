//
//  ArticlesViewModel.swift
//  iosApp
//
//  Created by bnnascimento94 on 05/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared


class ArticlesViewModel : ObservableObject{
    
    @Published var articles: [Article] = []
        
        init() {
            fetchArticles(forceFetch: false)
        }
        
    
    func fetchArticles(forceFetch: Bool) {

        ArticleInjector().listArticlesUsecase.invoke(forceFetch: forceFetch){ response, error in
            self.articles = response!
        }

    }
}
