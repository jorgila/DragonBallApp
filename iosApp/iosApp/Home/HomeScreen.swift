//
//  HomeScreen.swift
//  iosApp
//
//  Created by Jorge Gimeno Latas on 21/9/25.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync

struct HomeScreen: View {
    
    @StateViewModel
    var viewModel = HomeViewModel(repository: DiHelper().repository)
    
    
    var body: some View {
        if !viewModel.characters.isEmpty {
            LazyVStack{
                ForEach(viewModel.characters,id:\.self){ character in
                    Text(character.name)
                }
            }
        } else {
            Text("Error")
        }
           
    }
    
}

#Preview {
    HomeScreen()
}
