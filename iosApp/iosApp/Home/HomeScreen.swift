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
    var viewModel = HomeViewModel()
    
    
    var body: some View {
        Text(viewModel.example)
    }
    
}

#Preview {
    HomeScreen()
}
