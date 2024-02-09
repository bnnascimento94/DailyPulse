//
//  SourceViewModel.swift
//  iosApp
//
//  Created by bnnascimento94 on 09/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared


class SourceViewModel : ObservableObject{
    
    @Published var sources: [Source_] = []
        
        init() {
            fetchSources()
        }
        
    
    func fetchSources() {
        
            SourcesInjector().listSourceUsecase.invoke(){response, error in
                self.sources = response!
            }
        
    }
    

}
